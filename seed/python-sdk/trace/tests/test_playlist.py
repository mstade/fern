# This file was auto-generated by Fern from our API Definition.

from seed import SeedTrace
from seed import AsyncSeedTrace
import typing
import datetime
from .utilities import validate_response
from seed.playlist import UpdatePlaylistRequest


async def test_create_playlist(client: SeedTrace, async_client: AsyncSeedTrace) -> None:
    expected_response: typing.Any = {
        "name": "name",
        "problems": ["problems", "problems"],
        "playlist_id": "playlist_id",
        "owner-id": "owner-id",
    }
    expected_types: typing.Any = {
        "name": None,
        "problems": ("list", {0: None, 1: None}),
        "playlist_id": None,
        "owner-id": None,
    }
    response = client.playlist.create_playlist(
        service_param=1,
        datetime=datetime.datetime.fromisoformat("2024-01-15 09:30:00+00:00"),
        optional_datetime=datetime.datetime.fromisoformat("2024-01-15 09:30:00+00:00"),
        name="name",
        problems=["problems", "problems"],
    )
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.playlist.create_playlist(
        service_param=1,
        datetime=datetime.datetime.fromisoformat("2024-01-15 09:30:00+00:00"),
        optional_datetime=datetime.datetime.fromisoformat("2024-01-15 09:30:00+00:00"),
        name="name",
        problems=["problems", "problems"],
    )
    validate_response(async_response, expected_response, expected_types)


async def test_get_playlists(client: SeedTrace, async_client: AsyncSeedTrace) -> None:
    expected_response: typing.Any = [
        {"name": "name", "problems": ["problems", "problems"], "playlist_id": "playlist_id", "owner-id": "owner-id"},
        {"name": "name", "problems": ["problems", "problems"], "playlist_id": "playlist_id", "owner-id": "owner-id"},
    ]
    expected_types: typing.Tuple[typing.Any, typing.Any] = (
        "list",
        {
            0: {"name": None, "problems": ("list", {0: None, 1: None}), "playlist_id": None, "owner-id": None},
            1: {"name": None, "problems": ("list", {0: None, 1: None}), "playlist_id": None, "owner-id": None},
        },
    )
    response = client.playlist.get_playlists(
        service_param=1,
        limit=1,
        other_field="otherField",
        multi_line_docs="multiLineDocs",
        optional_multiple_field="optionalMultipleField",
        multiple_field="multipleField",
    )
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.playlist.get_playlists(
        service_param=1,
        limit=1,
        other_field="otherField",
        multi_line_docs="multiLineDocs",
        optional_multiple_field="optionalMultipleField",
        multiple_field="multipleField",
    )
    validate_response(async_response, expected_response, expected_types)


async def test_get_playlist(client: SeedTrace, async_client: AsyncSeedTrace) -> None:
    expected_response: typing.Any = {
        "name": "name",
        "problems": ["problems", "problems"],
        "playlist_id": "playlist_id",
        "owner-id": "owner-id",
    }
    expected_types: typing.Any = {
        "name": None,
        "problems": ("list", {0: None, 1: None}),
        "playlist_id": None,
        "owner-id": None,
    }
    response = client.playlist.get_playlist(service_param=1, playlist_id="playlistId")
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.playlist.get_playlist(service_param=1, playlist_id="playlistId")
    validate_response(async_response, expected_response, expected_types)


async def test_update_playlist(client: SeedTrace, async_client: AsyncSeedTrace) -> None:
    expected_response: typing.Any = {
        "name": "name",
        "problems": ["problems", "problems"],
        "playlist_id": "playlist_id",
        "owner-id": "owner-id",
    }
    expected_types: typing.Any = {
        "name": None,
        "problems": ("list", {0: None, 1: None}),
        "playlist_id": None,
        "owner-id": None,
    }
    response = client.playlist.update_playlist(
        service_param=1,
        playlist_id="playlistId",
        request=UpdatePlaylistRequest(name="name", problems=["problems", "problems"]),
    )
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.playlist.update_playlist(
        service_param=1,
        playlist_id="playlistId",
        request=UpdatePlaylistRequest(name="name", problems=["problems", "problems"]),
    )
    validate_response(async_response, expected_response, expected_types)


async def test_delete_playlist(client: SeedTrace, async_client: AsyncSeedTrace) -> None:
    # Type ignore to avoid mypy complaining about the function not being meant to return a value
    assert (
        client.playlist.delete_playlist(service_param=1, playlist_id="playlist_id")  # type: ignore[func-returns-value]
        is None
    )

    assert (
        await async_client.playlist.delete_playlist(service_param=1, playlist_id="playlist_id")  # type: ignore[func-returns-value]
        is None
    )
