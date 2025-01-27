package com.example.groceryapp

    import android.content.Context
    import android.os.Bundle
    import android.widget.Button
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import androidx.lifecycle.ViewModelProvider
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.lifecycle.Observer
    import androidx.recyclerview.widget.RecyclerView
    import com.example.groceryapp.ui.DialogListener
    import com.example.groceryapp.ui.GroceryItemDialog
    import com.example.groceryapp.ui.GroceryViewModel
    import com.example.groceryapp.ui.GroceryViewModelFactory

class MainActivity : AppCompatActivity() {

        lateinit var ViewModel: GroceryViewModel
        lateinit var list: List<GroceryItems>
        lateinit var rvList : RecyclerView
        lateinit var btnAdd : Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            btnAdd = findViewById(R.id.btnAdd)
            rvList = findViewById(R.id.rvList)
            val groceryRepository = GroceryRepository(GroceryDatabase(this))
            val factory = GroceryViewModelFactory(groceryRepository)

            // Initialised View Model
            ViewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)
            val groceryAdapter = GroceryAdapter(this,listOf(), ViewModel)
            rvList.layoutManager = LinearLayoutManager(this)
            rvList.adapter = groceryAdapter

            // To display all items in recycler view
            ViewModel.allGroceryItems().observe(this, Observer {
                groceryAdapter.list = it
                groceryAdapter.notifyDataSetChanged()
            })

            // on ClickListener on button to open dialog box
            btnAdd.setOnClickListener {
                GroceryItemDialog(this, object : DialogListener {
                    override fun onAddButtonClicked(item: GroceryItems) {
                        ViewModel.insert(item)
                    }
                },null).show()
            }

            @Override fun onResume(){
                super.onResume();
                setContentView(R.layout.activity_main);
                ViewModel.allGroceryItems().observe(this, Observer {
                    groceryAdapter.list = it
                    groceryAdapter.notifyDataSetChanged()
                })
            }
        }

        fun getContext(): Context {
            return this
        }
}