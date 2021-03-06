package com.example.foodinfo.utils

import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


/*
    activity.currentFocus вместо view т.к. после view.requestFocus() фокус может
    не успеть поставиться на view и showSoftInput вернет false, не отобразив
    клавиатуру, т.к. принял неправильную View, на которой не стоял фокус
 */
fun Fragment.showKeyboard(view: View) {
    this.requireActivity().let { activity ->
        view.requestFocus()
        ContextCompat.getSystemService(activity, InputMethodManager::class.java)
            ?.showSoftInput(activity.currentFocus, InputMethodManager.SHOW_IMPLICIT)
    }
}

/*
    HIDE_IMPLICIT_ONLY не подходит, закрывает только клавиатуру, которую я программно
    открыл. Но если нажать кнопку назад (сверху слева) то клавиатура, открытая при
    явном нажатии на EditText/SearchView останется и переедет на другой фрагмент
 */
fun Fragment.hideKeyboard() {
    this.requireActivity().let { activity ->
        val currentFocus = activity.currentFocus ?: return
        ContextCompat.getSystemService(activity, InputMethodManager::class.java)
            ?.hideSoftInputFromWindow(
                currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS
            )
    }
}

/*
     для фрагментов, которые лучше закрыть, уведомив пользователя, если нету данных для
     его полноценного функционирования
     например, свернули приложение на фрагменте с рецептами, почислили кэш на телефоне
     через условный CCleaner, выключили интернет, вернулись в приложение
     локальной бд нет, к серверу не подключиться, на экран выводить нечего - просим
     пользователя проверить подключение, он нажимает ок - закрываем фрагмент
 */
fun Fragment.handleNoData() {
    this.requireActivity().let { activity ->

        // TODO диалог с оповещением "проверьте подключение к интернету"
    }
}

