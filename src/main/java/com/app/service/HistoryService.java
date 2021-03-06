package com.app.service;

import com.app.model.History;
import com.app.repository.HistoryRepo;
import com.app.util.HistoryRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepo historyRepo;
    @Autowired
    private CurrencyService currencyService;

    public ArrayList<HistoryRecord> getHistoryRecordsById(long userId) {

        ArrayList<HistoryRecord> records = new ArrayList<>();

        historyRepo.findAllByUserId((int) userId)
                .forEach(record -> records
                        .add(new HistoryRecord(
                                currencyService.getCurrencyFullNameById(
                                        (long) record.getCurrencyFromId(userId)),
                                currencyService.getCurrencyFullNameById(
                                        (long) record.getCurrencyToId(userId)),
                                record.getSum(),
                                record.getSumObtained(),
                                record.getDate()
                        )));

        return records;
    }

    public void addRecord(HistoryRecord record, long id) {
        historyRepo.save(new History(
                (int) currencyService.getCurrencyIdByCharCodeAndDate(
                        record.getCurrencyFromName().split(" ")[0], record.getDate().minusDays(1L)),
                (int) currencyService.getCurrencyIdByCharCodeAndDate(
                        record.getCurrencyToName().split(" ")[0], record.getDate().minusDays(1L)),
                record.getSum(),
                record.getSumObtained(),
                (int) id,
                record.getDate()
        ));
    }
}
