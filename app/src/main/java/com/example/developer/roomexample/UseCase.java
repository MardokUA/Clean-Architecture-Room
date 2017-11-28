package com.example.developer.roomexample;

import com.example.developer.roomexample.data.source.remote.model.Error;

public interface UseCase<Q extends UseCase.RequestValues, K extends UseCase.ResponseValues> {

    void execute(Q values, UseCaseCallback<K> callback);

    interface RequestValues {

    }

    interface ResponseValues {

    }

    interface UseCaseCallback<R> {

        void onSuccess(R response);

        void onError(Error error);
    }
}
