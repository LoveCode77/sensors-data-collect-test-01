package com.xiong.cloud.service;

import org.springframework.stereotype.Service;
import java.util.Map;
@Service
public interface RealTimeDataService {

    Map getAllData();
    Map getAllData1();
    Map getFiveLayerSnsorData();
}
