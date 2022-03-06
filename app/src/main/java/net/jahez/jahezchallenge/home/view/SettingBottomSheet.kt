package net.jahez.jahezchallenge.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import net.jahez.domain.usecase.SortBy
import net.jahez.jahezchallenge.R
import net.jahez.jahezchallenge.databinding.FragmentSettingBottomSheetBinding
import net.jahez.jahezchallenge.home.vm.HomeActivityViewModel
import net.jahez.jahezchallenge.utils.Event

class SettingBottomSheet : BottomSheetDialogFragment() {
    private val activityViewModel: HomeActivityViewModel by activityViewModels<HomeActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSettingBottomSheetBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SettingBottomSheet.viewLifecycleOwner
            viewModel = this@SettingBottomSheet.activityViewModel
        }

        binding.chipGroupLanguage.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.chip_english -> {
                    activityViewModel.language.value = Event(HomeActivityViewModel.Language.ENGLISH)
                }

                R.id.chip_arabic -> {
                    activityViewModel.language.value = Event(HomeActivityViewModel.Language.ARABIC)
                }
            }
        }

        binding.chipGroupSorting.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.chip_distance -> {
                    activityViewModel.sorting.value = Event(SortBy.DISTANCE)
                }

                R.id.chip_offer -> {
                    activityViewModel.sorting.value = Event(SortBy.OFFER)
                }

                R.id.chip_rating -> {
                    activityViewModel.sorting.value = Event(SortBy.RATING)
                }
            }
        }

        binding.buttonApply.setOnClickListener {
            activityViewModel.applyChanges()
            dismiss()
        }


        binding.ivClose.setOnClickListener {
            dismiss()
        }

        binding.executePendingBindings()

        return binding.root
    }

}