package umc.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("tempCommandServiceImpl")
@RequiredArgsConstructor
public class TempCommandServiceImpl implements TempCommandService {  // Corrected interface implementation

    @Override
    public void CheckFlag(Integer flag) {
    }
}
