package modernJavaInAction.part01;

import static java.util.stream.Collectors.groupingBy;

import java.util.Currency;
import java.util.List;
import java.util.Map;
/**
 * 리스트에서 고가의 트랜잭션(거래)만 필터링한 다음 통화로 결과를 그룹화해야 한다고 가정
 * 스트림API에서는 라이브러리 내부에서 모든 데이터가 처리된다 -> 내부 반복(internal iteration)
 *   for-each 루프를 이용해서 각 요소를 반복하면서 작업을 수행 -> 외부 반복(external iteration)
 */
public class C1_4_Stream {
    Map<Currency, List<Transaction>> transactionByCurrencies = transactions.stream()
                                                                        .filter((Transaction t) -> t.getPrice() > 1000) // 고가의 트랜잭션 필터링
                                                                        .collect(groupingBy(Transaction::getCurrency)); // 통화로 그룹화
}
