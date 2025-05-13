package ru.yandexpraktikum.all_notes.di

import dagger.Subcomponent
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModelFactory
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AllNotesScope

@AllNotesScope
@Subcomponent(modules = [AllNotesModule::class])
interface AllNotesSubcomponent {
  fun getAllNotesViewModelFactory(): AllNotesViewModelFactory

  @Subcomponent.Factory
  interface Factory {
    fun create(): AllNotesSubcomponent
  }
}

