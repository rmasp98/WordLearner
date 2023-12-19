package cc.maspero.wordlearner.ui.practice

import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import cc.maspero.wordlearner.databinding.FragmentHomeBinding

class PracticeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun OnCreateView(inflater: LayoutInflater,
                              container: FragmentContainer,
                              savedInstanceState: SavedState
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}