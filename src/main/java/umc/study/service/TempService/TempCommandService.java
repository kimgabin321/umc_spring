package umc.study.service.TempService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface TempCommandService {
    void CheckFlag(Integer flag);
    // 서비스 메소드 정의
}
