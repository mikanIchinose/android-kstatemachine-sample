package io.github.mikan.sample.kstatemachine

import android.app.Application
import io.github.mikan.sample.kstatemachine.data.ArticleRepositoryImpl
import io.github.mikan.sample.kstatemachine.domain.ArticleRepository
import io.github.mikan.sample.qiita.remote.UserApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
           val mainModule = module {
                single<ArticleRepository> { ArticleRepositoryImpl(get()) }
                single<UserApi> {
                    UserApi().apply {
                        setBearerToken(BuildConfig.QiitaAccessToken)
                    }
                }
            }
            modules(mainModule)
        }
    }
}
