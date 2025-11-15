package com.example.UMC_Spring.domain.test.service.query;

import lombok.RequiredArgsConstructor;
import com.example.UMC_Spring.domain.test.exception.TestException;
import com.example.UMC_Spring.domain.test.exception.code.TestErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestQueryServiceImpl implements TestQueryService {

    @Override
    public void checkFlag(Long flag){
        if (flag == 1){
            throw new TestException(TestErrorCode.TEST_EXCEPTION);
        }
    }
}
