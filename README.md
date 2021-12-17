# week7

---

### GIF



### level 1-1

![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/72330632/146235660-57d12c96-fa3e-4853-8f8a-5f88aa316f35.gif)


NavigationComponent를 활용하여 다음과 같이 구현했습니다.

<img width="694" alt="스크린샷 2021-12-10 오후 8 54 53" src="https://user-images.githubusercontent.com/72330632/145570481-64080401-d4f5-40e6-8265-91cca00d0dfa.png">

마지막 fragment 에 시작하기 버튼을 누르면 finish()이후 Intent을 사용하여 SignInActivity로 이동합니다.

```kotlin
private fun initIntent() {
    binding.btnNext.setOnClickListener {
        requireActivity().finish()
        startActivity(Intent(requireActivity(), SignInActivity::class.java))
    }
}
```

### level 1-2

![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/72330632/146236742-9f5805b8-a28e-4e39-a91c-60e4ea8e4fe3.gif)


remove()를 사용하여 자동로그인 해제 한 다음 apply()로 적용한 모습입니다. 

```kotlin
fun setLogout(context: Context) {
    val preferences = context.getSharedPreferences(USER_AUTH, Context.MODE_PRIVATE)
    preferences.edit()
        .remove(AUTO_LOGIN)
        .apply()
}
```

### level 1-3

<img width="166" alt="스크린샷 2021-12-15 오후 11 13 53" src="https://user-images.githubusercontent.com/72330632/146202311-da2f3d7b-0918-462d-aabb-b6cd8f7b558b.png">

- adapter : 공용으로 사용될 adapter 정의 (현재는 adapter 와 관련된 모든 클래스를 넣어놓고는 있다....)
- data : data 클래스 등등
- util : Util과 같은 클래스가 있다. -> Util 클래스로 만든 이유는 자주사용하는 코드, 공용으로 사용해야 할 코드를 Util로 묶어두면 유용하기 때문에 만들었습니다.
- view : view 폴더 안에 activity, fragment, adapter 등으로 나뉘어 한눈에 보기 쉽다. (현재는 fragment, activity 로만 나뉨 )

해당 방식으로 패키징한 이유는 봤을 때 직관적으로 어느 패키지에 뭐가 있는지 알 수 있다는 장점이 있으며 , 검색을 해보니 MVP, MVVM 을 적용해 보면서
만들어진 구조라고 한다.

[comment]: <> (### level 2-1)

[comment]: <> (- gif 2-1)

[comment]: <> (- popUpTo : destination이 나올 때 까지 백스택을 팝업한다.)

[comment]: <> (- popUpInclusive : 지정되지 않거나 false 값인 경우 지정된 destination 경로는 백스택에 저장되어있고 나머지 도착점들을 모두 제거한다. )

[comment]: <> (true 값인 경우 지정된 경로를 포함하여 제거한다.)

[comment]: <> (- popUpInclusive 값이 true 이고, popUpTo 값이 시작점인 경우 백 버튼을 누르면 앱이 종료된다.)


[comment]: <> (### level 2-2)

[comment]: <> (- gif 2-2)

### 배운 점

- Navigation Component 사용법
- SharedPreference remove, clear 사용법
- 안드로이드 패키징 해야하는 이유
- popUpTo, popUpInclusive 사용법
- Toolbar, Appbar 사용법