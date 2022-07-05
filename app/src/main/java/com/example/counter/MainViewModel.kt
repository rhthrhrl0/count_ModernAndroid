package com.example.counter

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//savedStateHandle을 사용하면 뷰모델도 강제종료되는 경우 즉, 앱이 강제종료됐다가 살아날때 여기로 복구할 데이터를 넘겨준다.
class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private var count = savedStateHandle.get<Int>("count")?:0 //복구킷값이 없으면 0으로 설정.
        set(value) {
            countLiveData.value = value //라이브 데이터와 해당 변수를 묶어줌. 이 변수가 바뀌면 라이브데이터도 바뀌도록
            field = value
            //복구해야할 데이터 저장(갱신).
            savedStateHandle.set("count",value) //count킷값을 갱신.
        }
    val countLiveData = MutableLiveData<Int>()

    fun increaseCount(view: View) {
        count++
    }

    fun decreaseCount(view: View) {
        count--
    }

}