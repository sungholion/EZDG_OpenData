package com.openmind.ezdg.user.service;

import com.openmind.ezdg.user.dto.DataApplyDto;
import com.openmind.ezdg.user.entity.DataApplyEntity;
import com.openmind.ezdg.user.repository.DataApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    final private DataApplyRepository dataApplyRepository;

    public void applyData(DataApplyDto dataApplyDto) {
        DataApplyEntity dataApplyEntity = DataApplyEntity.toSaveEntity(dataApplyDto);

        dataApplyRepository.save(dataApplyEntity);

    }

    public List<DataApplyEntity> getAllDataApply() {
        return dataApplyRepository.findAll();
    }

    public boolean acceptDataApply(Long id) {
        Optional<DataApplyEntity> dataApplyEntityOpt = dataApplyRepository.findById(id);
        if (dataApplyEntityOpt.isPresent()) {
            DataApplyEntity dataApplyEntity = dataApplyEntityOpt.get();
            dataApplyEntity.setIsAccepted(true); // isAccepted 값을 true로 설정
            dataApplyRepository.save(dataApplyEntity); // 업데이트된 엔티티 저장
            return true;
        }
        return false;
    }
}
