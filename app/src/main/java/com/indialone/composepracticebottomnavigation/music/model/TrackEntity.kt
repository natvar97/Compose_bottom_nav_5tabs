package com.indialone.composepracticebottomnavigation.music.model

data class TrackEntity(
	val tracks: List<TracksItem?>? = null
)

data class LinksTracks(
	val albums: Albums? = null,
	val artists: Artists? = null,
	val genres: Genres? = null,
	val tags: Tags? = null,
	val composers: Composers? = null
)

data class Composers(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class Artists(
	val ids: List<String?>? = null,
	val href: String? = null
)

data class TracksItem(
	val albumName: String? = null,
	val isExplicit: Boolean? = null,
	val playbackSeconds: Int? = null,
	val formats: List<FormatsItem?>? = null,
	val previewURL: String? = null,
	val index: Int? = null,
	val albumId: String? = null,
	val isrc: String? = null,
	val artistId: String? = null,
	val type: String? = null,
	val shortcut: String? = null,
	val losslessFormats: List<LosslessFormatsItem?>? = null,
	val name: String? = null,
	val disc: Int? = null,
	val artistName: String? = null,
	val links: Links? = null,
	val id: String? = null,
	val href: String? = null,
	val blurbs: List<Any?>? = null,
	val contributors: Contributors? = null,
	val isAvailableInHiRes: Boolean? = null,
	val isStreamable: Boolean? = null
)

data class FormatsItem(
	val sampleBits: Int? = null,
	val name: String? = null,
	val bitrate: Int? = null,
	val type: String? = null,
	val sampleRate: Int? = null
)

data class Contributors(
	val featuredPerformer: String? = null,
	val primaryArtist: String? = null,
	val guestMusician: String? = null,
	val composer: String? = null,
	val producer: String? = null,
	val engineer: String? = null,
	val guestVocals: String? = null,
	val remixer: String? = null,
	val collaborator: String? = null,
	val nonPrimary: String? = null,
	val conductor: String? = null
)

data class Tags(
	val ids: List<String?>? = null,
	val href: String? = null
)



data class LosslessFormatsItem(
	val sampleBits: Int? = null,
	val name: String? = null,
	val bitrate: Int? = null,
	val type: String? = null,
	val sampleRate: Int? = null
)

data class Albums(
	val ids: List<String?>? = null,
	val href: String? = null
)

