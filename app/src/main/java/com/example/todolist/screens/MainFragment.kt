package com.example.todolist.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MAIN
import com.example.todolist.R
import com.example.todolist.adapter.TaskAdapter
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.databinding.FragmentMainBinding
import com.example.todolist.model.TaskModel
import java.util.*
import kotlin.collections.ArrayList


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var recycler: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        initialize()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            MAIN.navController.navigate(R.id.action_mainFragment_to_addFragment)
        }
    }
    private fun initialize() {
        recycler = binding.tasksRecyclerView
        recycler.adapter = MAIN.adapter
    }


}