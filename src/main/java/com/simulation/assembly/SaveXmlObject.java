package com.simulation.assembly;

import com.simulation.assembly.calculation.ca.CalculationKA;
import com.simulation.assembly.dataCalculation.sintez.DataCommonParameters;
import com.simulation.assembly.dataCalculation.sintez.DataElement;
import javafx.stage.FileChooser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class SaveXmlObject<T> {
    public final static String pathDomain = System.getProperty("user.home") + "\\sintez";


    public SaveXmlObject() {
        File file = new File(pathDomain);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void saveData(String nameObject, String type, T empty) {
        try {
            FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
            fileChooser.setTitle("Сохранение - " + nameObject);//Заголовок диалога
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter(nameObject + " *." + type, "*." + type);//Расширение
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(Main.getStage());
            if (file != null) {
                saveObject(file, empty);
                ControllerAssembly.showInfo(nameObject + " - успешно сохранено.");
            }
        } catch (Exception e) {
            ControllerAssembly.showError("Не удалось сохранить.");
        }
    }

    public T readData(String nameObject, String type, Class<?>... classesToBeBound) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть - " + nameObject);//Заголовок диалога

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(nameObject + " *." + type, "*." + type));
        File file = fileChooser.showOpenDialog(Main.getStage());
        T object = null;
        if (file != null) {
            if (file.getName().contains("." + type)) {
                try {
                    object = (T) readObject(file, CalculationKA.class);
                } catch (JAXBException e) {
                    ControllerAssembly.showError("Этот файл не поддерживается для " + nameObject + "\nВыберите файл с расширением ." + type);
                }
            } else {
                ControllerAssembly.showError("Этот файл не поддерживается " + nameObject + "\nВыберите файл с расширением ." + type);
            }
        }
        return object;
    }

    public void saveObject(File file, T object) throws JAXBException {
        JAXBContext js = JAXBContext.newInstance(object.getClass());
        Marshaller m = js.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(object, file);
    }

    public T readObject(File file, Class<?>... classesToBeBound) throws JAXBException {
        JAXBContext js = JAXBContext.newInstance(classesToBeBound);
        Unmarshaller um = js.createUnmarshaller();
        return (T) um.unmarshal(file);
    }

    public List<T> readDatumDomain(TabTypeSintez type) {
        List<T> list = new ArrayList<>();
        try {
            File folder = new File(pathDomain);
            FilenameFilter fileFilter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.contains("." + type.getTypeName());
                }
            };
            File[] listOfFiles = folder.listFiles(fileFilter);
            for (int i = 0; i < listOfFiles.length; i++) {
                list.add(readObject(listOfFiles[i], type.getTypeClass()));
            }
        } catch (Exception e) {
            ControllerAssembly.showError("Не удалось загрузить элементы.");
        }
        return list;
    }

    public void saveDatumDomain(T empty) {
        DataElement dataElement= (DataElement) empty;
        try {
            long id =((DataElement) empty).getId();
            File file = new File(pathDomain + "\\" + "data" + id + "." + dataElement.getType().getTypeName());
            saveObject(file, empty);
        } catch (JAXBException e) {
            ControllerAssembly.showError("Не удалось сохранить элемент.");
        }
    }

    public void deleteDatumDomain(TabTypeSintez type, long id) {
        File file = new File(pathDomain + "\\" + "data" + id + "." + type.getTypeName());
        if (file.delete())
            ControllerAssembly.showInfo("Елемент удален.");
        else
            ControllerAssembly.showError("Не удалось удалить элемент.");
    }
}
