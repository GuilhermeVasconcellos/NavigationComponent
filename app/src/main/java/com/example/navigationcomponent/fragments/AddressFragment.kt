package com.example.navigationcomponent.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentAddressBinding
import com.example.navigationcomponent.extensions.text
import com.example.navigationcomponent.model.Person


class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val args by navArgs<AddressFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("nav", "onViewCreated: $args")
        binding.btnNext.setOnClickListener {
            val person = Person(
                street = binding.tilStreet.text,
                number = binding.tilNumber.text.toInt(),
                name = args.person.name,
                age = args.person.age
            )
            val directions = AddressFragmentDirections.actionAddressFragmentToGlobalDataFragment(person)
            findNavController().navigate(directions)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}