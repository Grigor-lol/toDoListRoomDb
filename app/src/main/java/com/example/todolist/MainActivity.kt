package com.example.todolist

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todolist.adapter.TaskAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.db.AppDatabase
import com.example.todolist.db.TaskDao
import com.example.todolist.model.TaskModel
import java.util.UUID


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
     var adapter = TaskAdapter()

    var curList =  ArrayList<TaskModel>()
    lateinit var db: AppDatabase

    lateinit var taskDao: TaskDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MAIN = this
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "listDataBaseTest"
        ).allowMainThreadQueries().build()
        taskDao= db.taskDao()
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        adapter.setList(curList)
        initList()

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun initList() {
        val tasks: List<TaskModel> = taskDao.getAll()
        for (curTask in tasks){
            curList.add(curTask)
        }
    }


    fun onAdd(newTaskModel: TaskModel) {
        curList.add(newTaskModel)
        newTaskModel.uid = taskDao.insert(newTaskModel)
        adapter.setList(curList)
    }


}