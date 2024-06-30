package br.com.chronicles.interfaces;

import br.com.chronicles.model.entity.Chapter;
import br.com.chronicles.model.entity.FileWork;

import java.io.IOException;

public interface ChapterService {

    Chapter save(FileWork fileWork, String title, String description) throws IOException;
}
