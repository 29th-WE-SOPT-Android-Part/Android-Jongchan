# 2차 세미나 과제

---
### GIF

![](../../../Downloads/week2.gif)

---
### FollowerFragment

- onCreateView()로 생성될 떄 binding을 통해 정의합니다.
- onDestroyView()를 통해 activity가 끝날 경우 초기화 합니다.
- initFollowersAdapter()를 통해 Adapter를 Fragment에 연결시켜 View를 연동한 이후 list에 데이터를 추가
~~~kotlin
class FollowersFragment : Fragment() {
    private lateinit var followersAdapter: FollowersAdapter
    private var _binding: FragmentFollowersBinding? = null
    private val binding get() = _binding ?: error("FollowersBinding error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFollowersBinding.inflate(layoutInflater, container, false)
        initFollowersAdapter()
        return binding.root
    }

    private fun initFollowersAdapter() {
        followersAdapter = FollowersAdapter()
        binding.rvFollowers.adapter = followersAdapter
        followersAdapter.followerList.addAll(
            listOf(
                FollowerData("oxix", "비트코인 미리 사둘껄..."),
                FollowerData("Chan", "안녕하세요"),
                FollowerData("JONGCHAN", "이종찬입니다."),
                FollowerData("LEEJONGCHAN", "안드로이드 공부 열심히"),
                FollowerData("도지", "화성 갈끄니까~~~"),
                FollowerData("이종찬", "전동킥보드 타지 마세요 여러분"),
            )
        )
        followersAdapter.notifyDataSetChanged()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}
~~~
---
#### fragment_followers

- fragment_followers, fragment_repository에 LinearLayout, GridLayout를 설정하였습니다.

~~~xml
<androidx.recyclerview.widget.RecyclerView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/rv_followers"
            android:padding="16dp"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:itemCount="4"
            app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
    />
~~~

---
### FollowerAdapter

- FollowerData형식에 맞춰 item생성 후 layout에 적용되는 Adapter이다.

~~~kotlin
class FollowersAdapter : RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder>() {
    val followerList = mutableListOf<FollowerData>()

    class FollowersViewHolder(private val binding: FollowerListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: FollowerData) {
            binding.tvTitle.text = data.title
            binding.tvText.text = data.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val binding = FollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size
}
~~~

#### repository_list

- follower_list, repository_list를 생성하고 repository_list에는 ellipse="end"를 부여하여 범위 밖에 있는
내용을 ...처리하였다.

~~~xml
<androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent" xmlns:app="http://schemas.android.com/apk/res-auto"
        android:padding="16dp"
        android:layout_height="match_parent">

    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
              android:id="@+id/tv_title"
              android:text="title"
              android:textStyle="bold"
              android:textSize="14sp"
              app:layout_constraintStart_toStartOf="parent"
              app:layout_constraintTop_toTopOf="parent"/>
    <TextView android:layout_width="wrap_content" android:layout_height="wrap_content"
              android:id="@+id/tv_text"
              android:text="text"
              android:ellipsize="end"
              android:maxLines="1"
              android:ems="10"
              app:layout_constraintStart_toStartOf="@id/tv_title"
              app:layout_constraintTop_toBottomOf="@id/tv_title"/>
</androidx.constraintlayout.widget.ConstraintLayout>
~~~


### HomeActivity

- FollowersFragment, RepositoryFragment를 연결하는 버튼을 생성한 다음 이벤트 처리를 통해 각 연결된 fragment를 보여준다. 

~~~kotlin
private fun initTransactionEvent() {
        val followers = FollowersFragment()
        val repository = RepositoryFragment()
        supportFragmentManager.beginTransaction().add(R.id.container,followers).commit()
        binding.btFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,followers)
            transaction.commit()
        }
        binding.btRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,repository)
            transaction.commit()
        }
    }
~~~

#### action_home

~~~xml
 <androidx.fragment.app.FragmentContainerView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:id="@+id/container"
        android:padding="16dp"
        tools:layout = "@layout/fragment_repository"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@id/bt_follower"
        android:layout_margin="15dp"
/>
~~~ 

### 성장 내용

- Fragment 사용 방법과 생명 주기를 새로 알게 되어 한 화면에 다양한 View사용을 할 수 있게 되었다.
- RecyclerView를 통해 화면 구성하는 방법을 할 수 있게 되었다.
- RecyclerView를 통해 구현하는 과정에서 갑자기 item사이 간격이 넓어 지는 현상이 나타났는데 해당 문제를 해결하려고 노력중이다.
- Adapter를 통해 view를 연결시키는 방법을 배웠다.
- ellipsize를 사용 방법을 알게 되었다.
- 내가 이번 과제를 하면서 느낀점은 내가 많이 부족하고 더 열심히 해야한다는 것을 몸소 느낄 수 있었다. 
다른 것에 신경을 더 많이 썼는데 정신을 차리게 되었고 
100% 이해하지 못했기 때문에 확실하게 내용을 알아야 활용을 잘 할 수 있다는 것을 한번 더 깨달았다. 