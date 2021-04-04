package ru.StalkerNidus.labs.laba3;

import java.io.File;
import java.io.IOException;

public class FileUtils {

/*
    если файла не существует функции load вернут null
    все функции прорасывают ошибки наверх, те они не обрабывает их тут
    ошибки должны обрабатываться там, откуда вызывается загрузка или сохранение
*/

    public static void saveConfig(File path, GameConfig config) throws IOException{

    }
    public static GameConfig loadConfig(File path) throws IOException {

        return null;
    }

    public static void saveWorld(File path, World world) throws IOException{

    }
    public static World loadWorld(File path) throws IOException{

        return null;
    }
}
