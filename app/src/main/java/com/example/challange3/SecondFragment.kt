package com.example.challange3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.challange3.databinding.FragmentFourthBinding
import com.example.challange3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.btnGotoThird.setOnClickListener {
                if(binding.etInputName.text.isNullOrEmpty()){
                    Toast.makeText(requireContext(), "Input your name", Toast.LENGTH_SHORT).show()
                }
                else{
                    val actionToThirdFragment = SecondFragmentDirections.actionSecondFragmentToThirdFragment(null)
                    actionToThirdFragment.name = binding.etInputName.text.toString()
                    findNavController().navigate(actionToThirdFragment)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}