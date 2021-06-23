package com.indialone.composepracticebottomnavigation.music.model

data class ArtistEntity(
	val artists: List<ArtistsItem?>? = null,
)

data class RelatedProjects(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class ArtistsItem(
	val shortcut: String? = null,
	val bios: List<BiosItem?>? = null,
	val name: String? = null,
	val amg: String? = null,
	val albumGroups: AlbumGroups? = null,
	val links: Links? = null,
	val id: String? = null,
	val href: String? = null,
	val blurbs: List<String?>? = null,
	val type: String? = null
)

data class Influences(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class TopTracks(
	val href: String? = null
)


data class AlbumGroups(
	val compilations: List<String?>? = null,
	val main: List<String?>? = null,
	val others: List<String?>? = null,
	val singlesAndEPs: List<String?>? = null
)

data class BiosItem(
	val author: String? = null,
	val publishDate: String? = null,
	val bio: String? = null,
	val title: String? = null
)

data class LinksMusic(
	val albums: Albums? = null,
	val images: Images? = null,
	val followers: Followers? = null,
	val topTracks: TopTracks? = null,
	val genres: Genres? = null,
	val influences: Influences? = null,
	val stations: Stations? = null,
	val posts: Posts? = null,
	val contemporaries: Contemporaries? = null,
	val relatedProjects: RelatedProjects? = null
)

data class Stations(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class Followers(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class Contemporaries(
	val ids: List<String?>? = null,
	val href: String? = null
)

