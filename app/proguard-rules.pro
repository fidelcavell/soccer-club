# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn hilt_aggregated_deps._id_project_core_di_DataStoreModule
-dontwarn hilt_aggregated_deps._id_project_core_di_DatabaseModule
-dontwarn hilt_aggregated_deps._id_project_core_di_NetworkModule
-dontwarn hilt_aggregated_deps._id_project_core_di_RepositoryModule
-dontwarn id.project.core.data.source.Resource$Error
-dontwarn id.project.core.data.source.Resource$Loading
-dontwarn id.project.core.data.source.Resource$Success
-dontwarn id.project.core.data.source.Resource
-dontwarn id.project.core.data.source.local.LocalDataSource
-dontwarn id.project.core.data.source.remote.RemoteDataSource
-dontwarn id.project.core.data.source.remote.network.ApiService
-dontwarn id.project.core.di.DataStoreModule
-dontwarn id.project.core.di.DataStoreModule_ProvideDataStoreFactory
-dontwarn id.project.core.di.DatabaseModule
-dontwarn id.project.core.di.DatabaseModule_ProvideDatabaseFactory
-dontwarn id.project.core.di.DatabaseModule_ProvideSoccerClubDaoFactory
-dontwarn id.project.core.di.NetworkModule
-dontwarn id.project.core.di.NetworkModule_ProvideApiServiceFactory
-dontwarn id.project.core.di.NetworkModule_ProvideOkHttpClientFactory
-dontwarn id.project.core.di.RepositoryModule
-dontwarn id.project.core.di.RepositoryModule_ProvideRepositoryFactory
-dontwarn id.project.core.domain.model.SoccerClub
-dontwarn id.project.core.domain.repository.ISoccerClubRepository
-dontwarn id.project.core.domain.usecase.SoccerClubInteractor
-dontwarn id.project.core.domain.usecase.SoccerClubUseCase
-dontwarn id.project.core.ui.SoccerClubAdapter
-dontwarn id.project.core.ui.ThemePreferences
-dontwarn id.project.core.utils.AppExecutors