package fund.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * author : fanzhe
 * email : fansy1990@foxmail.com
 * date : 2021/1/9 PM12:27.
 */
@Getter
@Setter
@Entity
@Table(name = "fund_stock")
public class FundStock implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fundCode;

    private String stockCode;

    private String stockName;

    private String jingZhiPercent; // 净值比例

    private Double stockSize; // 持仓数

    private Double stockValue; // 持仓市值

    private Integer year;

    private Integer quater;

    public FundStock(){}

    public FundStock(String fundCode,String line){
        String[] lineData = line.split(",",-1);
//        id,code,name,jin_zhi_percent,chi_gu_shu,chi_cang_shi_zhi,year,quater
//        1,002127,南极电商,7.84%,2267.36,39134.65,2020,3
        this.fundCode = fundCode;
        this.stockCode = lineData[1];
        this.stockName = lineData[2];
        this.jingZhiPercent = lineData[3];
        this.stockSize = Double.parseDouble(lineData[4]);
        this.stockValue = Double.parseDouble(lineData[5]);
        this.year = Integer.parseInt(lineData[6]);
        this.quater = Integer.parseInt(lineData[7]);
    }


}
