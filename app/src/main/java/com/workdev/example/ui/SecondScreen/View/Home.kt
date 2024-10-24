package com.workdev.example.ui.SecondScreen.View

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.workdev.domain.entity.DataModelPosts.DataPost
import com.workdev.example.ui.SecondScreen.ViewModel.HomeViewModel
import com.workdev.example.R
import com.workdev.example.databinding.FragmentHomeBinding
import com.workdev.example.ui.SecondScreen.Utils.adapter.AdapterCategorey
import com.workdev.example.ui.SecondScreen.Utils.adapter.AdapterPepole
import com.workdev.example.ui.SecondScreen.Utils.adapter.AdapterPoster

class Home : Fragment() {
    lateinit var  binding :FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    val  AdapterPepole = AdapterPepole()
    val  AdapterCategorey = AdapterCategorey()
    val array=ArrayList<Int>()
    val arrayText=ArrayList<String>()
    val arraysub=ArrayList<String>()
    val arrayPost =ArrayList<DataPost>()
    val  adapters = AdapterPoster()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
       binding=FragmentHomeBinding.inflate(inflater, container, false)


        // images
        array.add(R.drawable.person_one)
        array.add(R.drawable.person_one)
        array.add(R.drawable.person_one)
        array.add(R.drawable.person_one)
        array.add(R.drawable.person_one)

        viewModel.Images(array)


        //  text Category
        arrayText.add("All")
        arrayText.add("UI/UX")
        arrayText.add("Illustration")
        arrayText.add("3D Animation")

        viewModel.Text(arrayText)

        arraysub.add("6 lessons")
        arraysub.add("UI/UX ")
        arraysub.add("Free")


        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))
        arrayPost.add(DataPost("Free e-book","Step design sprint for beginner","5h 21m",arraysub,
            R.drawable.womin,"Laurel Seilha","Product Designer"))


        viewModel.Poster(arrayPost)












        binding.rec.apply {
            layoutManager=
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter=AdapterPepole
        }




        viewModel.ImagesLive.observe(this@Home.requireActivity(), Observer { it->


            AdapterPepole.differ.submitList(it)



        })





        binding.recyclerViewCategory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = AdapterCategorey
        }



        viewModel.TextLive.observe(this@Home.requireActivity(), Observer { it->


            AdapterCategorey.differ.submitList(it)



        })







        binding.listPoster.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapters
        }


        viewModel.PostersLive.observe(this@Home.requireActivity(), Observer { it->


            adapters.differ.submitList(it)



        })























        return binding.root


    }
}