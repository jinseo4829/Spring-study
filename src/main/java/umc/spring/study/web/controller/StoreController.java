package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.domain.Store;
import umc.spring.study.service.StoreService.StoreCommandService;
import umc.spring.study.web.dto.StoreRequestDTO;
import umc.spring.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO> addStore(@Valid @RequestBody StoreRequestDTO requestDTO) {
        return ApiResponse.onSuccess(storeCommandService.createStore(requestDTO));
    }
}
