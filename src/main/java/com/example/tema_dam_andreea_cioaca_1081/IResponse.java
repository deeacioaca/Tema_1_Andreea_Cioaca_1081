package com.example.tema_dam_andreea_cioaca_1081;

import java.util.List;

public interface IResponse {
    public void onSuccess(List<TrackingCategory> list);
    public void onError(String mesaj);
}