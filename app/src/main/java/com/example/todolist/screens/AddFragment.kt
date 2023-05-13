package com.example.todolist.screens

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolist.MAIN
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddBinding
import com.example.todolist.databinding.FragmentMainBinding
import com.example.todolist.databinding.TaskLayoutBinding
import com.example.todolist.model.TaskModel
import java.util.*

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.closeButton.setOnClickListener {
            MAIN.navController.navigate(R.id.action_addFragment_to_mainFragment)
        }
        binding.addTaskButton.setOnClickListener {
            if (binding.taskEditText.text.toString() != "") {
                val newTask = TaskModel(binding.taskEditText.text.toString(), 0)
                MAIN.onAdd(newTask)
                MAIN.navController.navigate(R.id.action_addFragment_to_mainFragment)
            }
        }
    }
}