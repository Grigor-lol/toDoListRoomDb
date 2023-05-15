package com.example.todolist.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolist.Main
import com.example.todolist.Position
import com.example.todolist.R
import com.example.todolist.databinding.FragmentChangeBinding

class ChangeFragment : Fragment() {

    lateinit var binding: FragmentChangeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChangeBinding.inflate(layoutInflater, container, false)
        return binding.root
        return inflater.inflate(R.layout.fragment_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        var curElem = Main.curList[Position]
        binding.taskEditTextName.setText(curElem.textOfTask)
        binding.saveTaskButton.isEnabled = true


        binding.deleteTaskButton.setOnClickListener {
            Main.taskDao.delete(curElem)
            Main.curList.removeAt(Position)
            Main.navController.navigate(R.id.action_changeFragment_to_mainFragment)
        }

        binding.saveTaskButton.setOnClickListener {
            curElem.textOfTask =  binding.taskEditTextName.text.toString()
            Main.taskDao.updateTask(curElem)
            Main.navController.navigate(R.id.action_changeFragment_to_mainFragment)
        }

        binding.closeButton.setOnClickListener {
            Main.navController.navigate(R.id.action_changeFragment_to_mainFragment)
        }
    }
}