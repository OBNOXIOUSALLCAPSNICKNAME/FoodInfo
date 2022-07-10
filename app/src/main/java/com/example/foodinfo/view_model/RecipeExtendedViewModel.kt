package com.example.foodinfo.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodinfo.model.entities.RecipeShort
import com.example.foodinfo.model.repository.RepositoryRecipes
import javax.inject.Inject

class RecipeExtendedViewModel @Inject constructor(
    private val repositoryRecipes: RepositoryRecipes
) : ViewModel() {

    private val _recipe: MutableLiveData<RecipeShort> by lazy {
        MutableLiveData<RecipeShort>()
    }
    val recipe: LiveData<RecipeShort>
        get() = _recipe

    fun loadRecipe(recipeId: String) {
        _recipe.value = repositoryRecipes.getById(recipeId)
    }
}