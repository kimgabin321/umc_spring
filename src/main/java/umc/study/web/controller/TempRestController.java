package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.TempService.TempQueryService;
import umc.study.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    // Use @Qualifier to specify which TempQueryService implementation to inject
    @Qualifier("tempQueryServiceImpl")  // or "tempCommandServiceImpl" depending on which one you want
    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {
        TempResponse.TempTestDTO testDTO = TempResponse.TempTestDTO.builder()
                .testString("Hello World")
                .build();
        return ApiResponse.onSuccess(testDTO);
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
        tempQueryService.CheckFlag(flag);
        TempResponse.TempExceptionDTO exceptionDTO = TempResponse.TempExceptionDTO.builder()
                .flag(flag)
                .build();
        return ApiResponse.onSuccess(exceptionDTO);
    }
}
