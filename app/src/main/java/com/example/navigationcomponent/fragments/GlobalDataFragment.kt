package com.example.navigationcomponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentGlobalDataBinding


class GlobalDataFragment : Fragment() {

    private var _binding: FragmentGlobalDataBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val args by navArgs<GlobalDataFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGlobalDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNome.text = args.person.name
        binding.tvAge.text = args.person.age.toString()
        binding.tvStreet.text = args.person.street
        binding.tvNumber.text = args.person.number.toString()

        binding.btnBack.setOnClickListener {
            val directions = GlobalDataFragmentDirections.actionGlobalDataFragmentToPersonalDataFragment()
            findNavController().navigate(directions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}