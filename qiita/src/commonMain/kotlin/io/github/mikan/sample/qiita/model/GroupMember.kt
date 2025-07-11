/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package io.github.mikan.sample.qiita.model


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

/**
 * Qiita Teamのグループのメンバーを表します。
 *
 * @param id ユーザーID
 * @param name チームに登録しているユーザー名
 * @param email メンバーのemailアドレス(チームの管理者かオーナーでなければ空文字が返されます)
 */
@Serializable

data class GroupMember (

    /* ユーザーID */
    @SerialName(value = "id") @Required val id: kotlin.String,

    /* チームに登録しているユーザー名 */
    @SerialName(value = "name") @Required val name: kotlin.String,

    /* メンバーのemailアドレス(チームの管理者かオーナーでなければ空文字が返されます) */
    @SerialName(value = "email") @Required val email: kotlin.String

) {


}

