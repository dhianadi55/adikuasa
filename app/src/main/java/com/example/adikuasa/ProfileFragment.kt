package com.example.adikuasa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inisialisasi profil pengguna
        val user = getUserData() // Fungsi untuk mendapatkan data pengguna

        // Set data pengguna ke tampilan
        binding.textViewUsername.text = user.username
        binding.textViewGitHubUsername.text = user.githubUsername
        binding.textViewEmail.text = user.email

        // Set foto profil (huruf pertama dari nama pengguna)
        binding.imageViewProfileInitial.text = user.username.first().toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Contoh fungsi untuk mendapatkan data pengguna (diganti sesuai kebutuhan)
    private fun getUserData(): UserData {
        return UserData("admin", "dhianadi55", "dhian.121140055@student.itera.ac.id")
    }
}

// Data class untuk menyimpan data pengguna
data class UserData(
    val username: String,
    val githubUsername: String,
    val email: String
)
