package fund.service;

import fund.domain.FundStock;

import java.util.List;

/**
 * author : fanzhe
 * email : fansy1990@foxmail.com
 * date : 2021/1/9 PM12:26.
 */
public interface FundStockService {

    List<FundStock> saveAll(Iterable<FundStock> stocks);

    void saveFromPath(String path);
}
