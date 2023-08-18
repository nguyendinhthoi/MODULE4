package com.example.service;


import com.example.model.Language;
import com.example.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements ILanguageService {
    @Autowired
    private LanguageRepository languageRepo;

    @Override
    public List<Language> display() {
        return languageRepo.display();
    }

    @Override
    public Language findID(int id) {
        return languageRepo.findID(id);
    }

    @Override
    public List<String> displayName() {
        return languageRepo.displayName();
    }

    @Override
    public List<Integer> displaySize() {
        return languageRepo.displaySize();
    }

    @Override
    public void update(Language language, int id) {
        languageRepo.update(language,id);
    }
}
