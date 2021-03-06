package sample.gdgk.testing_sample.inject;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.model.RetrofitModel;

public class Injection {
    public static Scheduler ObserveScheduler() {
        return Schedulers.immediate();
    }

    public static Scheduler SubscribeScheduler() {
        return Schedulers.immediate();
    }

    public static RetrofitModel provideRetrofitModel() {
        return new FakeRetrofitModel();
    }

    public static VolleyModel provideVolleyModel() {
        return new FakeVolleyModel();
    }

}
