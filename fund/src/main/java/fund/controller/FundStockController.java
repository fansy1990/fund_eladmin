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
package fund.controller;

import fund.service.FundStockService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController

@RequestMapping("/fund_stock")
public class FundStockController {

    @Autowired
    private FundStockService fundStockService;


    @GetMapping(value = "/saveAll")

    public void saveAll(@RequestParam String path) throws IOException {
        fundStockService.saveFromPath(path);
    }


}