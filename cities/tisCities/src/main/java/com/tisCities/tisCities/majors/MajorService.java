package com.tisCities.tisCities.majors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class MajorService {

    private final MajorRepository majorRepository;

    @Autowired
    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public List<Major> getMajors() {
        return majorRepository.findAll();
    }

    public Major getMajor(Integer majorId) {
        return majorRepository.findById(majorId).get();
    }

    public void deleteMajor(Integer majorId) {
        Major major = this.getMajor(majorId);
        majorRepository.delete(major);
    }

    public void updateMajor(Integer majorId, String majorName, String majorSurname) {
        Major majorToUpdate = majorRepository.findById(majorId).get();
        majorToUpdate.setName(majorName);
        majorToUpdate.setSurname(majorSurname);
        majorRepository.save(majorToUpdate);
    }

    public void insertMajor(String majorName, String majorSurname) {
        Major major = new Major(majorName, majorSurname);
        majorRepository.save(major);
    }

    public List<Major> searchMajor(String searchTerm) {
        if (searchTerm != null && (!searchTerm.equals(""))) {
            return majorRepository.findBySearchString(searchTerm.toLowerCase(Locale.ROOT));
        }
        return getMajors();
    }
}
