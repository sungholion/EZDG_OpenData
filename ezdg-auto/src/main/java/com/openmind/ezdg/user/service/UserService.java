package com.openmind.ezdg.user.service;

import com.openmind.ezdg.user.dto.DataApplyDto;
import com.openmind.ezdg.user.entity.DataApplyEntity;
import com.openmind.ezdg.user.repository.DataApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private DataApplyRepository dataApplyRepository;

    public void applyData(DataApplyDto dataApplyDto) {
        DataApplyEntity dataApplyEntity = DataApplyEntity.toSaveEntity(dataApplyDto);

        dataApplyRepository.save(dataApplyEntity);

    }
}
