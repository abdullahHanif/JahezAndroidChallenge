package net.jahez.jahezchallenge.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import net.jahez.jahezchallenge.databinding.FragmentSettingBottomSheetBinding
import net.jahez.jahezchallenge.home.vm.HomeActivityViewModel

class SettingBottomSheet : BottomSheetDialogFragment() {
    private val activityViewModel: HomeActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSettingBottomSheetBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SettingBottomSheet.viewLifecycleOwner
            viewModel = this@SettingBottomSheet.activityViewModel
        }

        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.executePendingBindings()

        return binding.root
    }

   }