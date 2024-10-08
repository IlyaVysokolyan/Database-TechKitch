package com.store.database.controllers;

import com.store.database.DTO.Params.ParamsDto;
import com.store.database.DTO.VideoCard.UpdateVideoCardDto;
import com.store.database.DTO.VideoCard.VideoCardCreateDto;
import com.store.database.DTO.VideoCard.VideoCardDTO;
import com.store.database.interfaces.CRUDControllerOperations;
import com.store.database.service.VideoCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gpu")
public class VideoCardController implements CRUDControllerOperations<VideoCardDTO, VideoCardCreateDto, UpdateVideoCardDto> {

    private final VideoCardService videoCardService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<VideoCardDTO> index(
            ParamsDto param,
            @RequestParam(required = false) Double percentage) {

        if (percentage != null) {
            videoCardService.increasePrices(percentage);
        }
        return (param != null) ? videoCardService.sort(param) : videoCardService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VideoCardDTO getById(@PathVariable Long id) {
        return videoCardService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody VideoCardCreateDto dto) {
        videoCardService.create(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        videoCardService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UpdateVideoCardDto dto, @PathVariable Long id) {
        videoCardService.update(dto, id);
    }

}
