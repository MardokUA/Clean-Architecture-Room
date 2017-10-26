package com.example.developer.roomexample;


public abstract class UseCase<Q extends UseCase.RequestValues, K extends UseCase.ResponseValues> {

    private Q mRequestValues;
    private UseCaseCallback<K> mUseCaseCallback;

    public void setRequestValues(Q requestValues) {
        this.mRequestValues = requestValues;
    }

    public interface RequestValues {

    }

    public interface ResponseValues {

    }

    public interface UseCaseCallback<R> {

        void onSuccess(R response);

        void onError();
    }
}
