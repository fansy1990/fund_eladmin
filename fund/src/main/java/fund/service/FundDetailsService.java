package fund.service;

import fund.domain.FundStock;

import java.util.List;

/**
 * author : fanzhe
 * email : fansy1990@foxmail.com
 * date : 2021/1/9 PM12:20.
 */
public interface FundDetailsService {

    Integer save(FundStock fundStock);

    Integer save(List<FundStock> fundStocks);
}
