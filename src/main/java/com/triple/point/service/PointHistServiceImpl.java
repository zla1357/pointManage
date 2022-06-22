package com.triple.point.service;

import com.triple.point.domain.PointHist;
import com.triple.point.repository.PointHistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PointHistServiceImpl implements PointHistService {

    private final PointHistRepository pointHistRepository;

    @Transactional
    @Override
    public Long registerPointHist(PointHist pointHist) {
        pointHistRepository.registerPointHist(pointHist);
        return pointHist.getId();
    }

    @Override
    public PointHist getPointHist(Long id) {
        return pointHistRepository.getPointHist(id);
    }
}
