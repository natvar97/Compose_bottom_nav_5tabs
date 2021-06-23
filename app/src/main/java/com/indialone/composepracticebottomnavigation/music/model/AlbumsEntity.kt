package com.indialone.composepracticebottomnavigation.music.model

data class AlbumsEntity(
	val albums: List<AlbumsItem?>? = null,
	val meta: Meta? = null
)

data class AlbumsItem(
	val copyright: String? = null,
	val isExplicit: Boolean? = null,
	val upc: String? = null,
	val label: String? = null,
	val type: String? = null,
	val discCount: Int? = null,
	val tags: List<String?>? = null,
	val contributingArtists: ContributingArtists? = null,
	val trackCount: Int? = null,
	val shortcut: String? = null,
	val isSingle: Boolean? = null,
	val name: String? = null,
	val originallyReleased: String? = null,
	val discographies: Discographies? = null,
	val artistName: String? = null,
	val links: Links? = null,
	val id: String? = null,
	val href: String? = null,
	val accountPartner: String? = null,
	val isAvailableInHiRes: Boolean? = null,
	val released: String? = null,
	val isStreamable: Boolean? = null
)

data class Images(
	val href: String? = null
)

data class Discographies(
	val others: List<String?>? = null,
	val singlesAndEPs: List<String?>? = null,
	val main: List<String?>? = null
)

data class Links(
	val images: Images? = null,
	val artists: Artists? = null,
	val genres: Genres? = null,
	val posts: Posts? = null,
	val tracks: Tracks? = null
)

data class Genres(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class Meta(
	val returnedCount: Int? = null,
	val totalCount: Any? = null
)

data class ContributingArtists(
	val primaryArtist: String? = null
)

data class Tracks(
	val href: String? = null
)

data class Posts(
	val href: String? = null
)

