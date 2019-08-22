package com.bjc.service;

import com.bjc.entity.OverTim;
import com.bjc.entity.Rest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SelectOverTimeService {

    List<OverTim> selectOverTime(OverTim overtime);
    List<Rest> selectRest(Rest rest);

}
