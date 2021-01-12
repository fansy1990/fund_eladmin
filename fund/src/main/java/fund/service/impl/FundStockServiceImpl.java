/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package fund.service.impl;

import fund.domain.FundStock;
import fund.repository.FundStockRepository;
import fund.service.FundStockService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class FundStockServiceImpl implements FundStockService {
    private static final Logger log = LoggerFactory.getLogger(FundStockServiceImpl.class);

    @Autowired
    private  FundStockRepository fundStockRepository;


    @Override
    public  List<FundStock> saveAll(Iterable<FundStock> stocks) {
        return fundStockRepository.saveAll(stocks);
    }

    @Override
    public void saveFromPath(String path) {
        File parent = new File(path);
        if(!parent.exists() || !parent.isDirectory()){
            log.error("Folder {} is not exist or is not a folder !",path);
            return ;
        }

        File[] files = parent.listFiles();

        for(File file : files){
            saveAll(readFundStock(file));
        }
        log.info("{} files processed !", files.length);

    }

    private Iterable<FundStock> readFundStock(File file) {
        String fundCode = file.getName().replace(".csv","");
        List<FundStock> fundStocks = new ArrayList<>();
        List<String> lines ;
        try
        {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            fundStocks = lines.subList(1, lines.size()).stream()
                    .map(line -> new FundStock(fundCode,line))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("{} , fund has issue ! ", fundCode);
        }
        return fundStocks;
    }
}
